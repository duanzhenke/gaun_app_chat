function getParams(url) {
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
};

function sendPost(url, json) {
  $.ajax({
    type: "POST",
    url: url,
    contentType: "application/json", //必须这样写
    dataType: "json",
    data: JSON.stringify(json) ,//schoolList是你要提交是json字符串
    success: function (data) {
      console.log(data)
    },
    error:function (data) {
      alert("系统错误!");
    }
  })
}
