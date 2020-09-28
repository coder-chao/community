// const ENTITY_TYPE_POST = 1
// const ENTITY_TYPE_COMMENT = 2

// var editor = null

// var postId = 0
// var entityType = ENTITY_TYPE_POST
// var entityId = null
// var targetId = 0
// $(function () {
//
//     var E = window.wangEditor;
//     //这里的id为<div id="editor"中的id.
//     editor = new E('#editor');
//     // 配置服务器端地址,也就是controller的请求路径，不带项目路径，前面没有/
//     // editor.customConfig.uploadImgServer = 'commodity/upload/editor/img';
//     //配置属性名称，绑定请求的图片数据
//     //controller会用到，可以随便设置，但是一定要与controller一致
//     // editor.customConfig.uploadFileName = 'img';
//     //创建编辑器
//     editor.customConfig.uploadImgShowBase64 = true   // 使用 base64 保存图片
//     editor.customConfig.showLinkImg = false
//
//     editor.create();
//
//     // $("#editorSetBtn").click(function(){
//     //     //这是设置编辑器内容
//     //     console.log("dsafdfadsfdafdsfds");
//     // })
//     // document.getElementById('btn1').addEventListener('click', function () {
//     //     // 读取 html
//     //     alert(editor.txt.html())
//     // }, false)
//     //
//     // document.getElementById('btn2').addEventListener('click', function () {
//     //     // 读取 text
//     //     alert(editor.txt.text())
//     // }, false)
// })

// function publish() {
//     console.log(postId)
//     console.log(entityType)
//     console.log(entityId)
//     console.log(targetId)
//     // 获取标题和内容
//     var content = editor.txt.html();
//     // 发送异步请求(POST)
//     $.post(
//         CONTEXT_PATH + "/comment/add/" + postId,
//         {"content": content, "entityType": entityType, "entityId": entityId, "targetId": targetId},
//         function (data) {
//             console.log(data)
//             data = $.parseJSON(data);
//             // 在提示框中显示返回消息
//             $("#hintBody").text(data.msg);
//             // 显示提示框
//             $("#hintModal").modal("show");
//             // 2秒后,自动隐藏提示框
//             setTimeout(function () {
//                 $("#hintModal").modal("hide");
//                 // 刷新页面
//                 if (data.code == 0) {
//                     window.location.reload()
//                     // return false
//                 }
//             }, 2000);
//             // var entityType = null
//             // var entityId = null
//             // var targetId = 0
//         }
//     );
// }

// function inputFocus(et, ei, ti = 0) {
//     var position = $("#editor").offset();
//     position.top = position.top - 215;
//     $("html,body").animate({scrollTop: position.top}, 100);
//     //获取富文本编辑器的焦点
//     editor.$textElem.focus()
//     //赋值
//     entityType = et
//     entityId = ei
//     targetId = ti
//     // console.log(entityType)
//     // console.log(entityId)
//     // console.log(targetId)
//     // console.log(postId)
// }
