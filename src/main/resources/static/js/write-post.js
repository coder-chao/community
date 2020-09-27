var editor = null
$(function(){

    var E = window.wangEditor;
    //这里的id为<div id="editor"中的id.
    editor = new E('#editor');
    // 配置服务器端地址,也就是controller的请求路径，不带项目路径，前面没有/
    // editor.customConfig.uploadImgServer = 'commodity/upload/editor/img';
    //配置属性名称，绑定请求的图片数据
    //controller会用到，可以随便设置，但是一定要与controller一致
    // editor.customConfig.uploadFileName = 'img';
    //创建编辑器
    editor.customConfig.uploadImgShowBase64 = true   // 使用 base64 保存图片
    editor.customConfig.showLinkImg = false

    editor.create();

    // $("#editorSetBtn").click(function(){
    //     //这是设置编辑器内容
    //     console.log("dsafdfadsfdafdsfds");
    // })
    // document.getElementById('btn1').addEventListener('click', function () {
    //     // 读取 html
    //     alert(editor.txt.html())
    // }, false)
    //
    // document.getElementById('btn2').addEventListener('click', function () {
    //     // 读取 text
    //     alert(editor.txt.text())
    // }, false)
})

    function publish() {
        // 获取标题和内容
        var title = $(".shurukuang").val();
        var content = editor.txt.html();
        // 发送异步请求(POST)
        $.post(
            CONTEXT_PATH + "/discuss/add",
            {"title":title,"content":content},
            function(data) {
                console.log(data)
                data = $.parseJSON(data);
                // 在提示框中显示返回消息
                $("#hintBody").text(data.msg);
                // 显示提示框
                $("#hintModal").modal("show");
                // 2秒后,自动隐藏提示框
                setTimeout(function(){
                    $("#hintModal").modal("hide");
                    // 刷新页面
                    if(data.code == 0) {
                        window.location.href="/";
                        return false
                    }
                }, 2000);
            }
        );
}