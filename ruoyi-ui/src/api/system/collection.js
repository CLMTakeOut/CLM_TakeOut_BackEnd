import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listCollection(query) {
  return request({
    url: '/system/collection/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getCollection(collectionId) {
  return request({
    url: '/system/collection/' + collectionId,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addCollection(data) {
  return request({
    url: '/system/collection',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateCollection(data) {
  return request({
    url: '/system/collection',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delCollection(collectionId) {
  return request({
    url: '/system/collection/' + collectionId,
    method: 'delete'
  })
}

// 导出【请填写功能名称】
export function exportCollection(query) {
  return request({
    url: '/system/collection/export',
    method: 'get',
    params: query
  })
}