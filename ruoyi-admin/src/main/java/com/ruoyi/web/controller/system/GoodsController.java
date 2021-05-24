package com.ruoyi.system.controller;

import java.io.IOException;
import java.util.List;

import com.ruoyi.web.controller.myutils.FileUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Goods;
import com.ruoyi.system.service.IGoodsService;
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
@RequestMapping("/system/goods")
public class GoodsController extends BaseController
{
    @Autowired
    private IGoodsService goodsService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:goods:list')")
//    @PreAuthorize("hasAnyRole('admin,common')")
    @GetMapping("/list")
    public TableDataInfo list(Goods goods)
    {
        startPage();
        List<Goods> list = goodsService.selectGoodsList(goods);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:goods:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Goods goods)
    {
        List<Goods> list = goodsService.selectGoodsList(goods);
        ExcelUtil<Goods> util = new ExcelUtil<Goods>(Goods.class);
        return util.exportExcel(list, "goods");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:goods:query')")
    @GetMapping(value = "/{goodsId}")
    public AjaxResult getInfo(@PathVariable("goodsId") Integer goodsId)
    {
        return AjaxResult.success(goodsService.selectGoodsById(goodsId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:goods:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Goods goods)
    {
        return toAjax(goodsService.insertGoods(goods));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:goods:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Goods goods)
    {
        return toAjax(goodsService.updateGoods(goods));
    }
    /*
    * 上传商品图片
    * */
    @RequestMapping(value = "/upload/picture",method = RequestMethod.POST)
    public AjaxResult upload(@RequestParam("picture")MultipartFile file,@RequestParam("goodsId")Integer goodsId){
        String filePath =  FileUtil.uploadFile("/upload/goods/", String.valueOf(goodsId),file);
        System.out.println("上传路径:"+filePath);
        Goods goods = new Goods();
        goods.setGoodsId(goodsId);
        goods.setGoodsLogo(filePath);
        return toAjax(goodsService.updateGoods(goods));
    }
    /*获取商品图片*/
    @RequestMapping(value = "/getGoodsPicture/{goodsId}",method = RequestMethod.GET)
    public void getGoodsPicture(@PathVariable("goodsId")Integer goodsId, HttpServletResponse response) throws IOException {
        Goods goods = goodsService.selectGoodsById(goodsId);
        String url = goods.getGoodsLogo();
        System.out.println("头像地址："+url);
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
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:goods:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{goodsIds}")
    public AjaxResult remove(@PathVariable Integer[] goodsIds)
    {
        return toAjax(goodsService.deleteGoodsByIds(goodsIds));
    }
}
