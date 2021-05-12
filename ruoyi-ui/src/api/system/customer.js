import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listCustomer(query) {
  return request({
    url: '/system/customer/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getCustomer(customerId) {
  return request({
    url: '/system/customer/' + customerId,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addCustomer(data) {
  return request({
    url: '/system/customer',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateCustomer(data) {
  return request({
    url: '/system/customer',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delCustomer(customerId) {
  return request({
    url: '/system/customer/' + customerId,
    method: 'delete'
  })
}

// 导出【请填写功能名称】
export function exportCustomer(query) {
  return request({
    url: '/system/customer/export',
    method: 'get',
    params: query
  })
}