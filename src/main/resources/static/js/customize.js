function registered() {
    //注册页面
    location.href = 'registered/show';
}
function  doRegistered() {
    alert("abc");
    var val1 = $("#aaa").val();
    alert("11");
    alert(JSON.stringify(val1));
    $.ajax({
        type: "post",
        url: "registered/doRegistered",
        data: JSON.stringify(val1),
        dataType: "json",
        contentType: "application/json",
        success: function (r) {
            if (r.code == 0) {
                location.href = 'index';
            } else {
                alert(r.msg);
            }
        }
    });

}