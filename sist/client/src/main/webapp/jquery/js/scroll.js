//동적 태그 추가
$('<div class="scroll-bar-indicator"></div>')
    .css({
        width : 0,
        height: '7px',
        backgroundColor:'blue',
        position : 'fixed',
        left : 0,
        top :0,
        border : 0,
        padding : 0,
        margin : 0
    })
    .prependTo('body');

$(document).scroll(function(){
        // document.title = $(document).scrollTop();
        // document.title = $(document).outerHeight();

        let x = $(document).scrollTop() * 100 / $(document).outerHeight();

        $('.scroll-bar-indicator').css('width', x + '%');
})
