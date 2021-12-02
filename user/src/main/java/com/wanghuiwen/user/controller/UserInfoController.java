package com.wanghuiwen.user.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanghuiwen.base.model.User;
import com.wanghuiwen.base.service.UserService;
import com.wanghuiwen.common.MessageUtil;
import com.wanghuiwen.common.UtilFun;
import com.wanghuiwen.common.excel.ExcelUtil;
import com.wanghuiwen.core.controller.Ctrl;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.user.config.Const;
import com.wanghuiwen.user.config.UserResultEnum;
import com.wanghuiwen.user.model.UserInfo;
import com.wanghuiwen.user.service.*;
import com.wanghuiwen.user.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static com.wanghuiwen.user.config.UserResultEnum.VERIFICATION_ERROR;
import static com.wanghuiwen.user.config.UserResultEnum.VERIFICATION_INVALID;


/**
 * Created by wanghuiwen on 2021/10/18.
 */
@Api(value = "用户管理", tags = {"用户管理"})
@RestController
@RequestMapping("/user/info")
public class UserInfoController extends Ctrl {
    @Autowired
    Environment env;
    @Resource
    private MessageSource messageSource;
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private UserCompanyService userCompanyService;
    @Resource
    private UserService userService;
    @Resource
    private PositionService positionService;
    @Resource
    private RedisTemplate<String, String> redisTemplate;
    @Resource
    private NewestStoryService newestStoryService;
    @Resource
    private MmcEventService mmcEventService;
    @Resource
    private SliderService sliderService;

    @ApiOperation(value = "用户注册", tags = {"用户管理"}, notes = "用户注册")
    @PostMapping("register")
    public Result register(
            String phoneNumber,
            String verificationCode,
            String password,
            String countryCode
    ) {
        userInfoService.register(phoneNumber, verificationCode, password, countryCode);

        return resultGenerator.genSuccessResult();
    }


    @ApiOperation(value = "发送验证码", tags = {"用户管理"}, notes = "发送验证码")
    @PostMapping("send/verification")
    public Result sendVerification(@RequestParam String phoneNumber,
                                   @RequestParam String countryCode,
                                   @RequestParam Integer type) {
        String key = userInfoService.verificationCodeKey(phoneNumber, type);

        String code = redisTemplate.opsForValue().get(key);
        if (code != null) return resultGenerator.genSuccessResult();
        String verificationCode;
        if(Arrays.asList(env.getActiveProfiles()).contains("produce")){
            verificationCode  = UtilFun.getNumRandom(6);
            logger.info("verification=======" + verificationCode);
            //5分钟有效时间
            redisTemplate.opsForValue().set(key, verificationCode, 5, TimeUnit.MINUTES);
            //发送短信
            String message = messageSource.getMessage("user.verification.code", new String[]{verificationCode}, LocaleContextHolder.getLocale());
            MessageUtil.amazonSMSSender(countryCode+ " "+phoneNumber,message);
        }else{
            verificationCode = "987654";
            logger.info("verification=======" + verificationCode);
            //5分钟有效时间
            redisTemplate.opsForValue().set(key, verificationCode, 5, TimeUnit.MINUTES);
        }

        return resultGenerator.genSuccessResult();
    }


    @ApiOperation(value = "修改用户公司信息", tags = {"用户管理"}, notes = "修改用户公司信息")
    @PutMapping("company/update")
    public Result companyUpdate(@RequestBody CompanyVo companyVo) {
        return resultGenerator.genSuccessResult(userCompanyService.companyUpdate(companyVo));
    }


    @ApiOperation(value = "删除用户公司信息", tags = {"用户管理"}, notes = "删除用户公司信息")
    @DeleteMapping("/company/delete")
    public Result companyDelete(Long companyId) {
        userCompanyService.deleteById(companyId);
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "修改用户信息", tags = {"用户管理"}, notes = "修改用户信息")
    @PutMapping("/update")
    public Result update(@RequestBody UserInfo userInfo,Authentication authentication) {
        userInfoService.update(userInfo);
        UserInfoVo userInfoVo = userInfoService.detail(userInfo.getUserId(), getAuthUser(authentication).getId());
        Achievement achievement =  userInfoService.achievements(userInfo.getUserId(),1);
        userInfoVo.setAchievement(achievement);
        return resultGenerator.genSuccessResult(userInfoVo);
    }


    @ApiOperation(value = "Network", tags = {"用户管理"}, notes = "Network")
    @GetMapping("/network")
    public Result network(@RequestParam(defaultValue = "1") Integer page,
                          @RequestParam(defaultValue = "10") Integer size,
                          @RequestParam(required = false) String name,
                          @RequestParam(required = false) String industry,
                          @RequestParam(required = false) Long countryId,
                          @RequestParam(required = false) Long cityId,
                          @RequestParam(required = false) Long groupId,
                          Authentication authentication) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("Industry", industry);
        params.put("countryId", countryId);
        params.put("cityId", cityId);
        params.put("groupId", groupId);
        params.put("userId", getAuthUser(authentication).getId());
        params.put("userGrade", getAuthUser(authentication).getGrade());
        PageHelper.startPage(page, size);
        List<UserNetWorkVo> netWorkVos = userInfoService.network(params);
        PageInfo<UserNetWorkVo> netWorkVoPageInfo = new PageInfo<>(netWorkVos);
        return resultGenerator.genSuccessResult(netWorkVoPageInfo);
    }

    @ApiOperation(value = "用户的network", tags = {"用户管理"}, notes = "用户的network")
    @GetMapping(value = "/my/network", name = "用户的network")
    public Result myNetwork(@RequestParam(defaultValue = "1") Integer page,
                            @RequestParam(defaultValue = "10") Integer size,
                            @RequestParam(required = false) String name,
                            @RequestParam(required = false) String industry,
                            @RequestParam(required = false) Long countryId,
                            @RequestParam(required = false) Long cityId,
                            @RequestParam(required = false) Long groupId,
                            Authentication authentication) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("Industry", industry);
        params.put("countryId", countryId);
        params.put("cityId", cityId);
        params.put("groupId", groupId);
        params.put("userId", getAuthUser(authentication).getId());
        params.put("onlySelf", true);

        PageHelper.startPage(page, size);
        List<UserNetWorkVo> netWorkVos = userInfoService.network(params);
        PageInfo<UserNetWorkVo> netWorkVoPageInfo = new PageInfo<>(netWorkVos);
        return resultGenerator.genSuccessResult(netWorkVoPageInfo);
    }


    @ApiOperation(value = "用户管理列表信息", tags = {"用户管理"}, notes = "用户管理列表信息")
    @GetMapping(value = "/list", name = "用户管理详细信息")
    public Result list(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Long groupId,
            @RequestParam(required = false) Long gradeId,
            @RequestParam(required = false) Long positionId
    ) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("groupId", groupId);
        params.put("gradeId", gradeId);
        params.put("positionId", positionId);
        PageHelper.startPage(page, size);
        List<UserInfoVo> userInfoVoList = userInfoService.managerList(page, size, params);
        PageInfo<UserInfoVo> pageInfo = new PageInfo<>(userInfoVoList);
        return resultGenerator.genSuccessResult(pageInfo);
    }


    @ApiOperation(value = "用户导出", tags = {"用户管理"}, notes = "用户导出")
    @GetMapping(value = "/export", name = "用户导出")
    public void export(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Long groupId,
            @RequestParam(required = false) Long gradeId,
            @RequestParam(required = false) Long positionId,
            HttpServletResponse response
    ) throws IOException {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("groupId", groupId);
        params.put("gradeId", gradeId);
        params.put("positionId", positionId);
        List<UserInfoVo> userInfoVoList = userInfoService.managerList(1, 0, params);
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("用户信息");
        // 设置要导出的文件的名字
        String fileName = "mmc_users"  + new Date() + ".xls";
        // 新增数据行，并且设置单元格数据
        int rowNum = 1;

        String[] headers = { "membership", "Name", "D.O.B", "Contact Num","Email","Industry","Company Name","group","Grade"};
        HSSFRow row = sheet.createRow(0);
        for(int i=0;i<headers.length;i++){
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        //在表中存放查询到的数据放入对应的列
        for (UserInfoVo item : userInfoVoList) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(item.getGradeName());
            row1.createCell(1).setCellValue(item.getName());
            if(item.getBirthday() != null){
                row1.createCell(2).setCellValue(UtilFun.DateToString(new Date(item.getBirthday()),"MM/dd/YYYY"));
            }
            row1.createCell(3).setCellValue(item.getConcatNumber());
            row1.createCell(4).setCellValue(item.getEmail());
            row1.createCell(5).setCellValue(item.getIndustry());
            StringBuilder companyName = new StringBuilder();
            for (CompanyVo companyVo : item.getCompanyVos()) {
                companyName.append(companyVo.getCompanyName()).append("\n");
            }
            row1.createCell(6).setCellValue(companyName.toString());
            row1.createCell(7).setCellValue(item.getGroupName());
            row1.createCell(8).setCellValue(item.getPositionName());
            rowNum++;
        }

        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }


    @ApiOperation(value = "用户端用户详情", tags = {"用户管理"}, notes = "用户端用户详情")
    @GetMapping(value = "/detail", name = "用户端用户详情")
    public Result detail(Long userId, Authentication authentication,@RequestParam(defaultValue = "1") Integer type) {
        UserInfoVo userInfoVo = userInfoService.detail(userId, getAuthUser(authentication).getId());
        Achievement achievement =  userInfoService.achievements(userId,type);
        userInfoVo.setAchievement(achievement);
        return resultGenerator.genSuccessResult(userInfoVo);
    }

    @ApiOperation(value = "首页数据", tags = {"用户管理"}, notes = "首页数据")
    @GetMapping(value = "/index", name = "首页数据")
    public Result detail(Authentication authentication) {
        UserInfoVo userInfoVo = userInfoService.detail(getAuthUser(authentication).getId());
        Map<String, Object> res = new HashMap<>();
        res.put("user", userInfoVo);
        res.put("notice", new ArrayList<>());
        PageHelper.startPage(1, 2);
        List<NewestStoryVo> newset = newestStoryService.list(new HashMap<>());
        res.put("newset", newset);
        PageHelper.startPage(1, 2);
        List<EventVoAdd> events = mmcEventService.upcomingEvent(getAuthUser(authentication));
        res.put("upcoming", events);
        List<SliderVo> sliderVos = sliderService.userList(getAuthUser(authentication).getId());
        res.put("slider",sliderVos);
        return resultGenerator.genSuccessResult(res);
    }


    @ApiOperation(value = "用户忘记密码", tags = {"用户管理"}, notes = "用户忘记密码")
    @PutMapping(value = "forgot/password", name = "用户忘记密码")
    public Result forgotPassword(
            String phoneNumber,
            String verificationCode,
            String password
    ) {
        String key = userInfoService.verificationCodeKey(phoneNumber, Const.VERIFICATION_FORGOT);
        String code = redisTemplate.opsForValue().get(key);
        if (code == null) {
            return resultGenerator.genFailResult(VERIFICATION_INVALID);
        }
        if (!verificationCode.equals(code)) {
            return resultGenerator.genFailResult(VERIFICATION_ERROR);
        }
        User user = userService.findByLoginName(phoneNumber);
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        userService.update(user);
        redisTemplate.delete(key);
        return resultGenerator.genSuccessResult();
    }


    @ApiOperation(value = "用户修改密码", tags = {"用户管理"}, notes = "用户修改密码")
    @PutMapping(value = "update/password", name = "用户修改密码")
    public Result forgotPassword(
            String oldPassword,
            String password,
            Authentication authentication
    ) {
        User user = userService.findById(getAuthUser(authentication).getId());
        if(!new BCryptPasswordEncoder().matches(oldPassword,user.getPassword())){
            return  resultGenerator.genFailResult(UserResultEnum.OLD_PASSWORD_NOT_MATCH);
        }
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        userService.update(user);
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "用户职位下拉选项", tags = {"用户管理"}, notes = "用户职位下拉选项")
    @GetMapping(value = "/position/list", name = "用户职位下拉选项")
    public Result positionList() {
        return resultGenerator.genSuccessResult(positionService.findAll());
    }


    @ApiOperation(value = "导入用户", tags = {"用户管理"}, notes = "导入用户")
    @PostMapping(value = "import", name = "导入用户")
    public Result importUser(MultipartFile file) throws IOException {
        List<List<String>> excelData = ExcelUtil.read(file);
        userInfoService.excelToUser(excelData);
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "用户数据统计", tags = {"用户管理"}, notes = "用户数据统计")
    @GetMapping(value = "achievements", name = "用户数据统计")
    public Result achievements(Authentication authentication,@RequestParam(defaultValue = "1") Integer type){
        Achievement achievement =  userInfoService.achievements(getAuthUser(authentication).getId(),type);
        return resultGenerator.genSuccessResult(achievement);
    }

    @ApiOperation(value = "行业列表", tags = {"用户管理"}, notes = "行业列表")
    @GetMapping(value = "industry", name = "行业列表")
    public Result industry(){
        List<Industry> industries = new ArrayList<>();
        industries.add(new Industry("Accounting","会计"));
        industries.add(new Industry("Administrative","行政"));
        industries.add(new Industry("Agricultural","农业"));
        industries.add(new Industry("Apparel","服装"));
        industries.add(new Industry("Appearance","形象"));
        industries.add(new Industry("Appliances","电器"));
        industries.add(new Industry("Architecture","建筑"));
        industries.add(new Industry("Art","艺术"));
        industries.add(new Industry("Automotive","汽车"));
        industries.add(new Industry("Cleaning","清洁"));
        industries.add(new Industry("Computer","电脑"));
        industries.add(new Industry("Delivery","递送"));
        industries.add(new Industry("Education & Advisory","教育与咨询"));
        industries.add(new Industry("Electronics & Gadget","电子产品"));
        industries.add(new Industry("Employment","雇人"));
        industries.add(new Industry("Engineering","工程"));
        industries.add(new Industry("Entertainment","娱乐"));
        industries.add(new Industry("Event Planning & Public Relation","活动策划与公关"));
        industries.add(new Industry("Financial","金融"));
        industries.add(new Industry("Food/Beverages","食品/饮料"));
        industries.add(new Industry("Funeral","葬礼"));
        industries.add(new Industry("Furniture","家具"));
        industries.add(new Industry("Gifts","礼物"));
        industries.add(new Industry("Groceries Supply","食品供应"));
        industries.add(new Industry("Hardware","五金"));
        industries.add(new Industry("Health & Wellness","卫生与健康"));
        industries.add(new Industry("Home Living & Appliances","家庭用品与家电"));
        industries.add(new Industry("IT","信息技术"));
        industries.add(new Industry("Insurance","保险"));
        industries.add(new Industry("Interior Design","室内设计"));
        industries.add(new Industry("Jewelry & Accessories","珠宝与配件"));
        industries.add(new Industry("Language","语言"));
        industries.add(new Industry("Legal","法律"));
        industries.add(new Industry("Logistic","物流"));
        industries.add(new Industry("Marketing","市场营销"));
        industries.add(new Industry("Media & Photography","媒体与摄影"));
        industries.add(new Industry("Medical","医疗"));
        industries.add(new Industry("Non-Profit","非营利性集团"));
        industries.add(new Industry("Photography","摄影"));
        industries.add(new Industry("Printing & Packaging","印刷与包装"));
        industries.add(new Industry("Real Estate","房地产"));
        industries.add(new Industry("Security","保安"));
        industries.add(new Industry("Sports","体育"));
        industries.add(new Industry("Stationery","文具"));
        industries.add(new Industry("Telecommunication","电信"));
        industries.add(new Industry("Travel","旅游业"));
        Locale locale = LocaleContextHolder.getLocale();
        if(locale.getCountry().equals(Locale.SIMPLIFIED_CHINESE.getCountry())){
            return resultGenerator.genSuccessResult(industries.stream().map(Industry::getCnName).collect(Collectors.toList()));
        }
        return resultGenerator.genSuccessResult(industries.stream().map(Industry::getEnName).collect(Collectors.toList()));
    }
}
