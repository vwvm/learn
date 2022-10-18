//全局变量:保存广告div初始时的top和left值
let adStyleTop = 0
let adStyleLeft = 0

//计算:广告div初始化时的top和left值。只要计算一次，所以，放在body的onload事件进行调用。
function first() {
    console.log("hhh")
    let obj = document.getElementById("ad");
    //判断是否是IE
    if (document.currentScript)//IE支持的
    {
        adStyleTop = parseInt(document.getElementById("ad").currentstyle.top);
        adStyleLeft = parseInt(document.getElementById("ad").currentstyle.left);
    } else {
        adStyleTop = parseInt(document.defaultView.getComputedStyle(obj, null).top);
        adStyleLeft = parseInt(document.defaultView.getComputedStyle(obj, null).left);
    }//PF等
    adStyleTop = document.getElementById("ad").getBoundingClientRect().top
    adStyleLeft = document.getElementById("ad").getBoundingClientRect().left
    console.log(adStyleTop)
    console.log(adStyleLeft)
}

//body的onscro11事件时调用，当滚动条滚动时就会调用的方法。
//这个方法，计算当前滚动条所滚动的数据，加上div的初始数据，形成新的数据，然后赋给div
function scroll() {
    console.log("滚动了")
    let obj = document.getElementById("ad");
    let adScrollTop = parseInt(document.body.scrollTop || document.documentElement.scrollTop);
    let adScrollLeft = parseInt(document.body.scrollLeft || document.documentElement.scrollLeft);
    //新的位置-div的初始数据+滚动条所滚动的数据
    const newTop = adStyleTop + adScrollTop + "px";
    const newLeft = adStyleLeft + adScrollLeft + "px";
    //将新的位置赋给广告div
    obj.style.top = newTop;
    obj.style.left = newLeft;
}


function closeAD() {
    document.getElementById("ad").style.display = 'none'
}

