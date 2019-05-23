var common = {
    init: function () {
        //this.bindEvent();
        // this.render(menu['home']);
    },
    bindEvent: function () {
        var self = this;
        // 按钮单击事件
        $(document).on('click', '.paoding-common-btn', function () {
            var type = $(this).data('type');
            common[type] ? common[type].call(this) : '';
        });
        // 顶部大菜单单击事件
        $(document).on('click', 'ul.paoding-header-nav li', function () {
            if (common.databaseId) {
                common.databaseId = null;
            }
            $("ul.paoding-header-nav li").removeClass("paoding-this");
            $(this).addClass("paoding-this");
            var menu = $(this).find("a").data("menu");
            var url = $(this).find("a").data("url");
            common.appType = menu;
            var sideMenu = common.changeSideMenus(menu);
            common.renderMainPage(sideMenu, url, menu);
            //;
            //common.renderMainPage(crmSideMenu, '/app/crm/company', 'crm');
            return false;
        });

        $(document).on('click', '.sider-nav li', function () {
            $('.sider-nav li').removeClass('current');
            $(this).addClass('current');
            $('iframe').attr('src', $(this).data('src'));
        });

        $(document).on('click', '.pf-logout', function () {
            layer.confirm('您确定要退出吗？', {
                icon: 4,
                title: '确定退出' //按钮
            }, function () {
                location.href = 'login.html';
            });
        });
        //左侧菜单收起
        $(document).on('click', '.toggle-icon', function () {
            $(this).closest("#pf-bd").toggleClass("toggle");
            setTimeout(function () {
                $(window).resize();
            }, 300)
        });

        $(document).on('click', '.pf-modify-pwd', function () {
            $('#pf-page').find('iframe').eq(0).attr('src', 'backend/modify_pwd.html')
        });

        $(document).on('click', '.pf-notice-item', function () {
            $('#pf-page').find('iframe').eq(0).attr('src', 'backend/notice.html')
        });

    },
}
$(function () {

});