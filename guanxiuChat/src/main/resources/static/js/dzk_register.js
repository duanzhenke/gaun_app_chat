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
        dataSearch(e) {
            this.guanChat.birthday = e;
        },

        checkPass_wd() {
            if (this.confirm_passwd !== this.guanChat.passWord) {
                alert("两次密码不一致！")
            }
        },
        // 校验必填信息
        check_req() {
            if (this.guanChat.userName && this.guanChat.gender &&
                this.guanChat.maritalStatus && this.selectDay &&
                this.guanChat.passWord && this.guanChat.phoneNumber) {
                this.flag = false
            } else {
                alert("请填写所有的必填参数！")
            }
        },
        check_code() {
            let user_code = this.getCookie("user_code")
            if (this.page_code === user_code && this.page_code) {
                //更改是否注册状态
                this.registe_status = true
            } else {
                alert("手机校验码不正确！")
            }
        },

        // 保存注册用户的信息
        saveOne() {
            axios.post(this.baseUrl + "guanChat/saveOne", this.guanChat).then(function (response) {
                alert("注册成功了")
                console.log(response.data);
            }).catch(function (error) {
                console.log(error);
            });
        },
        //2.根据手机号，获取短信校验码。
        sendMsg() {
            let _this = this;
            axios.get(this.baseUrl + "sendMsg?phoneNumber=" + this.guanChat.phoneNumber)
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
                while (c.charAt(0) === ' ') c = c.substring(1)
                if (c.indexOf(name) !== -1) {
                    return c.substring(name.length, c.length)
                }
            }
            return ''
        },
        clearCookie: function (cname) {
            this.setCookie(cname, '', -1)
        }
        // 设置cookie的方法结束
    }

})