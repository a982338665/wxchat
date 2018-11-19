//login.js
//获取应用实例
const app = getApp()

Page({
  data: {
   
  },
  //事件处理函数
  // bindViewTap: function() {
  //   wx.navigateTo({
  //     url: '../logs/logs'
  //   })
  // },
  onLoad: function () {
    
  },
  doLogin: function(e) {
    // console.log(e)
    console.log(e.detail.errMsg)
    console.log(e.detail.iv)
    console.log(e.detail.encryptedData) 
    wx.login({
      success:function(res){
        //临时凭证：5分钟
        console.log(res.code)
        var code=res.code
        //调用后端获取微信session_key和secret 
        wx.request({
          url: 'http://127.0.0.1:8080/wxLogin?code='+code,
          method:"post",
          success:function(result){
            console.log(result)
          }
        })
      }
    })
  }
})
