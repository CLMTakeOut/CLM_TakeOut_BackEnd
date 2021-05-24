import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listGoods(query) {
  return request({
    url: '/system/goods/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getGoods(goodsId) {
  return request({
    url: '/system/goods/' + goodsId,
    method: 'get'
  })
}
// 获取商品图片
export function getGoodsPicture(imgUrl) {
  return request({
    url: imgUrl,
    method: 'get',
    responseType: "blob"
  })
}
// 新增【请填写功能名称】
export function addGoods(data) {
  return request({
    url: '/system/goods',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateGoods(data) {
  return request({
    url: '/system/goods',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delGoods(goodsId) {
  return request({
    url: '/system/goods/' + goodsId,
    method: 'delete'
  })
}

// 导出【请填写功能名称】
export function exportGoods(query) {
  return request({
    url: '/system/goods/export',
    method: 'get',
    params: query
  })
}