package com.ruoyi.system.controller;

import java.io.IOException;
import java.util.List;

import com.ruoyi.system.domain.Goods;
import com.ruoyi.web.controller.myutils.FileUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Shop;
import com.ruoyi.system.service.IShopService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2021-05-12
 */
@RestController
@RequestMapping("/system/shop")
public class ShopController extends BaseController
{
    @Autowired
    private IShopService shopService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:shop:list')")
    @GetMapping("/list")
    public TableDataInfo list(Shop shop)
    {
        startPage();
        List<Shop> list = shopService.selectShopList(shop);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:shop:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Shop shop)
    {
        List<Shop> list = shopService.selectShopList(shop);
        ExcelUtil<Shop> util = new ExcelUtil<Shop>(Shop.class);
        return util.exportExcel(list, "shop");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:shop:query')")
    @GetMapping(value = "/{shopId}")
    public AjaxResult getInfo(@PathVariable("shopId") Integer shopId)
    {
        return AjaxResult.success(shopService.selectShopById(shopId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:shop:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Shop shop)
    {
        return toAjax(shopService.insertShop(shop));
    }

    /*上传店铺log图片*/
    @RequestMapping(value = "/upload/logo",method = RequestMethod.POST)
    public AjaxResult upload(@RequestParam("shopLog") MultipartFile file, @RequestParam("shopId")Integer shopId){
        String filePath =  FileUtil.uploadFile("/upload/shop/", String.valueOf(shopId),file);
        System.out.println("上传路径:"+filePath);
        Shop shop = new Shop();
        shop.setShopId(shopId);
        shop.setShopLogo(filePath);
        return toAjax(shopService.updateShop(shop));
    }

    /*获取店铺log*/
    @RequestMapping(value = "/getShopLogo/{shopId}",method = RequestMethod.GET)
    public void getGoodsPicture(@PathVariable("shopId")Integer shopId, HttpServletResponse response) throws IOException {
        Shop shop = shopService.selectShopById(shopId);
        String url = shop.getShopLogo();
        System.out.println("店铺Logo地址："+url);
        if (url != null){
            byte[] bytes = FileUtil.getFileBytes(url);
            // 设置返回类型
            response.setContentType("image/jpeg");
            response.setCharacterEncoding("UTF-8");
            ServletOutputStream stream = response.getOutputStream();
//            System.out.println("长度:"+bytes.length);
            stream.write(bytes);
        }
    }
    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:shop:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Shop shop)
    {
        return toAjax(shopService.updateShop(shop));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:shop:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{shopIds}")
    public AjaxResult remove(@PathVariable Integer[] shopIds)
    {
        return toAjax(shopService.deleteShopByIds(shopIds));
    }
}
