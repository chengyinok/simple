'use strict'

//详细资料参考http://www.datatables.club/reference/option/
var defaultOption = {
    "language": {
        "sProcessing":   "处理中...",
        "sLengthMenu":   "显示 _MENU_ 项结果",
        "sZeroRecords":  "没有匹配结果",
        "sInfo":         "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
        "sInfoEmpty":    "显示第 0 至 0 项结果，共 0 项",
        "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
        "sInfoPostFix":  "",
        "sSearch":       "搜索:",
        "sUrl":          "",
        "sEmptyTable":     "表中数据为空",
        "sLoadingRecords": "载入中...",
        "sInfoThousands":  ",",
        "oPaginate": {
            "sFirst":    "首页",
            "sPrevious": "上页",
            "sNext":     "下页",
            "sLast":     "末页"
        },
        "oAria": {
            "sSortAscending":  ": 以升序排列此列",
            "sSortDescending": ": 以降序排列此列"
        },
        buttons: {
            colvis: '列隐藏'
        }
    },
    dom: 'frBtip',                       //定义DataTables的组件元素的显示和显示顺序
    "paging": true,                      //是否开启本地分页
    "searching": false,                 //是否允许Datatables开启本地搜索
    "serverSide": true,                 //是否开启服务器模式
    "ordering": false,                  //是否允许Datatables开启排序
    "lengthChange": true,               //关闭左上角的记录条数 false:关闭，true：开启
    "info": true,                        //是否显示页脚信息，DataTables插件左下角显示记录数
    "stateSave": false,                  //保存状态 - 在页面重新加载的时候恢复状态（页码等内容）
    "destroy": true,                     //销毁所有符合选择的table，并且用新的options重新创建表格
    "lengthMenu": [10, 30, 50, 100],     //定义在每页显示记录数的select中显示的选项
    "pagingType": "full_numbers",      //首页，尾页，上一页和下一页四个按钮,加上数字按钮
    "fnServerData": Base.dataTableFnserver,// 执行方法
    "autoWidth": false, // 自适应宽度
};

$.fn.myDataTable = function (option) {

    option = $.extend(true, {}, defaultOption, option);

    //设置列的为空时的默认值为空，避免出现为空的弹窗警告
    for (var i = 0; i < option.columns.length; i++) {
        if(!option.columns[i].defaultContent){
            option.columns[i].defaultContent = "";
        }
    }

    //操作列的defaultContent不能覆盖掉
    if(option.columnDefs){
        for (var i = 0; i < option.columnDefs.length; i++) {
            var item = option.columnDefs[i];
            if(item.defaultContent){
                if(item.targets < 0){
                    option.columns[option.columns.length + item.targets].defaultContent = item.defaultContent;
                }else{
                    option.columns[item.targets].defaultContent = item.defaultContent;
                }

            }
        }
    }
    return $(this).DataTable(option);
}