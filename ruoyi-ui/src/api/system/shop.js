import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listShop(query) {
  return request({
    url: '/system/shop/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getShop(shopId) {
  return request({
    url: '/system/shop/' + shopId,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addShop(data) {
  return request({
    url: '/system/shop',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateShop(data) {
  return request({
    url: '/system/shop',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delShop(shopId) {
  return request({
    url: '/system/shop/' + shopId,
    method: 'delete'
  })
}

// 导出【请填写功能名称】
export function exportShop(query) {
  return request({
    url: '/system/shop/export',
    method: 'get',
    params: query
  })
}