var mySwiper = new Swiper('.swiper-container',{

    //设置自动播放
    autoplay: {
        delay: 2000,
        disableOnInteraction: false
    },
    //设置无限循环播放
    loop: true,
    //设置圆点指示器
    pagination: {
        el: '.swiper-pagination',
    },
    //设置上下页按钮
    navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
    }
})


$(function () {
    $("#keyword").keypress(function (e) {
        var key = e.which;
        //回车键
        if (key == 13) {
            var keyValue = $(this).val();
            if (keyValue && keyValue != '') {
                window.location.href = "/search?keyword=" + keyValue;
            }
        }
    });
});
/**
 * 搜索框
 */
function search() {
    
    var keyword = $("#keyword").val();
    if (keyword && keyword != ''){
        window.location.href = "/search?keyword=" + keyword;
    }
}

