$(document).ready(function () {
    var tds = $("td");
    //var tds = $("#sampleName");
    //var tds = document.getElementsByName('sampleName');
    //alert(tds);
    //给所有的td节点增加点击事件
    tds.click(tdclick);
});

function tdclick() {
    console.log('point1')
    var clickfunction = this;
    var td = $(this);
    var tr = td.parentNode;

    var sampleId = $(tr).val();
    var text = $(this).text();
    td.html("");
    var input = $("<input>");
    input.attr("value", text);
    input.keyup(function (event) {
        console.log('point2')
        var myEvent = event || window.event;
        var kcode = myEvent.keyCode;
        if (kcode === 13) {
            var inputnode = $(this);
            var inputext = inputnode.val();
            var tdNode = inputnode.parent();
            tdNode.html(inputext);
            tdNode.click(tdclick);
            if (inputext !== text) {                    //只有当内容不一样时才进行保存
                //后台交互的地方
                console.log('sampleId:', sampleId)
                sampleNameUpdate(sampleId, inputext, 'sampleAlterAction.action');
            }
        }
    });
    td.append(input);
    var inputdom = input.get(0);
    inputdom.select();
    td.unbind("click");
}