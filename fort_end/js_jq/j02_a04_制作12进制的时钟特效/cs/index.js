let year, month, day, hour, minute, second, pm, week
const spanList = document.getElementsByTagName("span")
const weekList = ["日","一","二","三","四","五","六"]
function nowData() {
    const date = new Date()
    year = date.getFullYear()
    month = date.getMonth() + 1
    day = date.getDate()
    week = date.getDay()
    hour = date.getHours()
    if (hour > 12){
        hour -= 12
        pm = "pm"
    }else {pm = "am"}
    minute = date.getMinutes()
    second = date.getSeconds()
    spanList[0].innerHTML = (year + "年" + month + "月" + day + "日")
    spanList[1].innerHTML = (hour + ":" + minute + ":" + second)
    spanList[2].innerHTML = pm
    spanList[3].innerHTML = "星期" + weekList[week]
}
window.setInterval(nowData, 500)
