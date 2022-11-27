window.onload = function () {
    //选择框
    var checkbox = getClass("checkbox");
    //所选商品总费用
    var pricecount = document.getElementById("pricecount");
    //商品件数
    var selectedTotal = document.getElementById("selectedTotal");

    var tbody = document.getElementById("tbody");
    var tr = tbody.getElementsByTagName("tr");

    for (var i = 0; i < checkbox.length; i++) {
        checkbox[i].onclick = function () {
            //全选事件
            if (this.className == 'checkbox-all checkbox') {
                for (var j = 0; j < checkbox.length; j++) {
                    checkbox[j].checked = this.checked;
                }
            }

            getTotal()
        }
    }

    for (var i = 0; i < tr.length; i++) {
        tr[i].onclick = function (e) {
            var e = window.event || e;
            var target = e.target || e.srcElement;

            var input1 = this.getElementsByTagName("input")[1]

            switch (target.className) {
                case 'layui-btn layui-btn-primary layui-btn-sm add':
                    input1.value = parseInt(input1.value) + 1;
                    break;

                case 'layui-btn layui-btn-primary layui-btn-sm reduce':
                    if (input1.value <= 1) {
                        input1.value = 1;
                    } else {
                        input1.value = parseInt(input1.value) - 1;
                    }

                    break;

            }
            getTotal()
        }
    }
}

function getClass(cName) {
    var doms = document.getElementsByTagName("*");
    var domArr = [];
    for (var i = 0; i < doms.length; i++) {
        if (doms[i].className == cName || doms[i].className.indexOf(" " + cName) != -1 || doms[i].className.indexOf(cName + " ") != -1) {
            domArr.push(doms[i])
        }
    }
    return domArr;
}


//合计、已选商品件数
function getTotal() {

    //获取tr
    var tbody = document.getElementById("tbody");
    var tr = tbody.getElementsByTagName("tr");
    var price = 0;
    var selected = 0;

    for (var i = 0; i < tr.length; i++) {
        var input = tr[i].getElementsByTagName("input");

        if (input[0].checked) {
            //小计=单价*数量
            var td3 = tr[i].getElementsByTagName('td')[3].innerText;
            var td5 = tr[i].getElementsByTagName('td')[5];
            var numCount = parseInt(input[1].value);

            td5.innerText = td3 * numCount;

            price += parseFloat(tr[i].getElementsByTagName('td')[5].innerText);
            selected += parseInt(input[1].value)
        }

    }
    pricecount.innerText = price.toFixed(2);
    selectedTotal.innerText = selected;
}


