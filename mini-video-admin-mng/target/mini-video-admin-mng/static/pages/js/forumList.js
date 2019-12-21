


//定义讲座列表对象
var UserForumList = function () {

    var handleUserForumList = function () {
        var hdnContextPath = $("#hdnContextPath").val();
        var jqGrid = $("#usersForumList");
        jqGrid.jqGrid({
            caption: "讲座列表",
            url: hdnContextPath + "/forum/forumList.action",
            mtype: "post",
            styleUI: 'Bootstrap',
            datatype: "json",
            colNames: ['ID', '标题', '地点', '描述', '参与人数', '日期', '开始时间', '状态'],
            colModel:[
                { name: 'id', index: 'id', width: 30, sortable: false, hidden: false },
                { name: 'forumTitle', index: 'forumTitle', width: 30, sortable: false },
                { name:'forumAddress',index:'forumAddress', width:30,sortable:false},
                { name:'forumDesc',index:'forumDesc', width:60,sortable:false},
                { name:'joinCounts',index:'joinCounts', width:30,sortable:true},
                { name:'forumDate',index:'forumDate', width:30,sortable:true},
                { name:'forumStart',index:'forumStart', width:30,sortable:true},
                { name: 'status', index: 'status', width: 40, sortable: false, hidden: false,
                    formatter:function(cellvalue, options, rowObject) {
                        if(cellvalue==0){
                            return '未开始';
                        }else if(cellvalue==1){
                            return '进行中';
                        }else if(cellvalue==2){
                            return '已结束';
                        }else{
                            return '异常'
                        }
                }
                },

            ],
            viewrecords: true,  		// 定义是否要显示总记录数
            rowNum: 10,					// 在grid上显示记录条数，这个参数是要被传递到后台
            rownumbers: true,  			// 如果为ture则会在表格左边新增一列，显示行顺序号，从1开始递增。此列名为'rn'
            autowidth: true,  			// 如果为ture时，则当表格在首次被创建时会根据父元素比例重新调整表格宽度。如果父元素宽度改变，为了使表格宽度能够自动调整则需要实现函数：setGridWidth
            height: 500,				// 表格高度，可以是数字，像素值或者百分比
            rownumWidth: 36, 			// 如果rownumbers为true，则可以设置行号 的宽度
            pager: "#usersForumListPager",		// 分页控件的id
            subGrid: false				// 是否启用子表格
        }).navGrid('#usersForumListPager', {
            edit: false,
            add: false,
            del: true,
            search: false
        },{},{},
            // options for the Delete Dailog
            {
                url:hdnContextPath+'/forum/delForum.action',
                reloadAfterSubmit:true
                // afterSubmit:function (data,datapost) {
                //     alert(data.toString())
                //     alert(datapost.toString())
                // }
            });


        // 随着窗口的变化，设置jqgrid的宽度
        $(window).bind('resize', function () {
            var width = $('.usersReportsList_wrapper').width()*0.99;
            jqGrid.setGridWidth(width);
        });
    };



    return {
        // 初始化各个函数及对象
        init: function () {debugger;
            handleUserForumList();
        }
    };




}();

jQuery(document).ready(function() {
    UserForumList.init();
});