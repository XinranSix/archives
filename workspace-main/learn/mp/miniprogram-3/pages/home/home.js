// pages/home/home.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },
  gotoMessage() {
    wx.switchTab({
      url: '/pages/message/message'
    })
  },
  gotoInfo() {
    wx.navigateTo({
      url: '/pages/info/info',
    })
  },
  gotoInfo2() {
    wx.navigateTo({
      url: '/pages/info/info?name=ls&gender=男',
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom() {
    console.log('触发了 home 页面的上拉触底');
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage() {

  }
})