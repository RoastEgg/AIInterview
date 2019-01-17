// miniprogram/pages/videoInterview/videoInterview.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    currentIndex: 0,
    currentPerson: {
      id: 0,
      name: '',
      organization: '',
      filePath: '',
      applyPurpose: 0,//求职动机
      affinity: 0,//亲和力
      aotugnosis: 0,//自我认知
      confidence: 0,//自信力
      expression: 0,//表达能力
      face: 0,//形象气质
      stability: 0,//情绪稳定
      detail: {

      }
    },
    persons: [{
      id: 1,
      name: '赵大华',
    }, {
      id: 2,
      name: '马连良',
    }, {
      id: 3,
      name: '陈文斌',
    }, {
      id: 4,
      name: '沈萍',
    }, {
      id: 5,
      name: '沈亚楠',
    }, {
      id: 6,
      name: '张鹏',
    }, {
      id: 7,
      name: '李天',
    }, {
      id: 8,
      name: '李泽明',
    }, {
      id: 9,
      name: '蓝田',
    }, {
      id: 10,
      name: '卢海龙',
    }]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let self = this;
    wx.request({
      url: 'http://47.101.49.230/interviewee/getInterviewees',
      // header: {
      //   'content-type': 'application/json' // 默认值
      // },
      success(res) {
        console.log(res.data)
        let persons = res.data.map((name, index) => {
          return {
            id: index,
            name: name
          }
        })
        self.setData({
          persons: persons
        })
        self.fetchOnePerson(res.data[0])
      }
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    // this.videoContext = wx.createVideoContext('myVideo')
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },

  fetchOnePerson: function (name) {
    let self = this;
    wx.request({
      url: 'http://47.101.49.230/interviewee/getDescAndScore',
      method: 'POST',
      data: {
        name: name
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded' // 默认值
      },
      success(res) {
        let videoPath = res.data.filePath
        videoPath = encodeURI("http://47.101.49.230/interviewee/videos/"+videoPath.substring(videoPath.lastIndexOf("/")+1))
        let person = { ...res.data, id: 0, name: name,videoPath:videoPath }
        self.setData({
          currentPerson: person
        })
        // self.videoContext.play();
        // self.videoContext.stop();
      }
    })
  },

  tapPerson: function (e) {
    // this.videoContext.stop();
    
    let person = e.currentTarget.dataset.person
    let index = e.currentTarget.dataset.index
    if(index != this.data.currentIndex){
      this.setData({
        currentIndex: index,
        currentPerson: person
      })
      this.fetchOnePerson(person.name)
    }
  }
})