const vm = new Vue({
  el: '#app',
  data: {
    baseUrl: "http://localhost:9097/",
    guanChat: {},
    selectDay: "",
    confirm_passwd: "",
    registe_status: false,
    flag: true,
    page_code: "",  //页面用户填写的code
  },
  methods: {
    // 保存注册用户的信息
    saveOne() {
      //获得了当前链接的中?号后的参数
      var params = window.location.href;
      var guanChat = this.getParams(params);
      console.log(guanChat)
      axios.post(this.baseUrl + "guanChat/saveOne", guanChat).then(
          function (response) {
            console.log(response.data);
          }).catch(function (error) {
        console.log(error);
      });
    },
    //2.根据手机号，获取短信校验码。
    sendMsg() {
      let _this = this;
      axios.get(
          this.baseUrl + "sendMsg?phoneNumber=" + this.guanChat.phoneNumber)
      .then(function (response) {
        let user_code = response.data.data.code; //后台生成的user_code 存入coolie中
        _this.setCookie("user_code", user_code, 1);
        alert("短信校验码，发送成功。")
      }).catch(function (error) {
        console.log(error);
      });
    },

    // 设置cookie的方法
    setCookie(cname, cvalue, exdays) {
      let d = new Date()
      d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000))
      let expires = 'expires=' + d.toUTCString()
      document.cookie = cname + '=' + cvalue + '; ' + expires
    },
    getCookie(cname) {
      let name = cname + '='
      let ca = document.cookie.split(';')
      // console.log("获取cookie,现在循环")
      for (let i = 0; i < ca.length; i++) {
        let c = ca[i]
        // console.log(c)
        while (c.charAt(0) === ' ') {
          c = c.substring(1)
        }
        if (c.indexOf(name) !== -1) {
          return c.substring(name.length, c.length)
        }
      }
      return ''
    },
    clearCookie: function (cname) {
      this.setCookie(cname, '', -1)
    },
    // 设置cookie的方法结束

    // url 转为对象属性
    getParams(url) {
      try {
        var index = url.indexOf('?');
        url = url.match(/\?([^#]+)/)[1];
        var obj = {}, arr = url.split('&');
        for (var i = 0; i < arr.length; i++) {
          var subArr = arr[i].split('=');
          var key = decodeURIComponent(subArr[0]);
          var value = decodeURIComponent(subArr[1]);
          obj[key] = value;
        }
        return obj;
      } catch (err) {
        return null;
      }
    }
  }

})