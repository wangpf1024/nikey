
if (typeof jQuery === 'undefined') {
    throw new Error('Nikey\'s JavaScript requires jQuery')
}

+function ($) {
    'use strict';
    var version = $.fn.jquery.split(' ')[0].split('.')
    if ((version[0] < 2 && version[1] < 9) || (version[0] == 1 && version[1] == 9 && version[2] < 1)) {
        throw new Error('Nikey\'s JavaScript requires jQuery version 1.9.1 or higher')
    }
}(jQuery);


+function ($) {
    'use strict';

    //定义导航栏对象
    var navbar = function(){
        this.$id = "#navbar";//模版id
        this.$nav = $(this.$id);//模版对象
        this.$pathname = window.location.pathname.substr(1);
        this.$active =  'Home';//默认选中标签
        this.$p_selector = "data-p";//标签属性选择器
        //对象方法
        this.init = function(){
            if(this.$pathname){
                var i = this.$pathname.indexOf("/");
                //二级目录
                if(i > 0){
                    this.$active = this.$pathname.substr(0,i);
                }else{
                    this.$active = this.$pathname;//一级目录
                };
            };
        };
    }

    //原型方法：添加选中效果
    navbar.prototype.active = function(){
        this.init();
        this.$nav.find('['+this.$p_selector+'='+this.$active+']').addClass('active');
    }

    $(window).on('load', function () {
        var nav = new navbar();
        nav.active();
    })

}(jQuery);