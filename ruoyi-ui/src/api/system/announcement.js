import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listAnnouncement(query) {
  return request({
    url: '/system/announcement/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getAnnouncement(announcementId) {
  return request({
    url: '/system/announcement/' + announcementId,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addAnnouncement(data) {
  return request({
    url: '/system/announcement',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateAnnouncement(data) {
  return request({
    url: '/system/announcement',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delAnnouncement(announcementId) {
  return request({
    url: '/system/announcement/' + announcementId,
    method: 'delete'
  })
}

// 导出【请填写功能名称】
export function exportAnnouncement(query) {
  return request({
    url: '/system/announcement/export',
    method: 'get',
    params: query
  })
}