import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listOrder(query) {
  return request({
    url: '/system/order/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getOrder(orderId) {
  return request({
    url: '/system/order/' + orderId,
    method: 'get'
  })
}

// 根据订单id查询对应的商品详情
export function getOrderDetails(orderId) {
  return request({
    url: "/system/order/getOrderDetails/" + orderId,
    method: "get"
  })
}

// 新增【请填写功能名称】
export function addOrder(data) {
  return request({
    url: '/system/order',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateOrder(data) {
  return request({
    url: '/system/order',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delOrder(orderId) {
  return request({
    url: '/system/order/' + orderId,
    method: 'delete'
  })
}

// 导出【请填写功能名称】
export function exportOrder(query) {
  return request({
    url: '/system/order/export',
    method: 'get',
    params: query
  })
}