import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listAddress(query) {
  return request({
    url: '/system/address/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getAddress(addressId) {
  return request({
    url: '/system/address/' + addressId,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addAddress(data) {
  return request({
    url: '/system/address',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateAddress(data) {
  return request({
    url: '/system/address',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delAddress(addressId) {
  return request({
    url: '/system/address/' + addressId,
    method: 'delete'
  })
}

// 导出【请填写功能名称】
export function exportAddress(query) {
  return request({
    url: '/system/address/export',
    method: 'get',
    params: query
  })
}