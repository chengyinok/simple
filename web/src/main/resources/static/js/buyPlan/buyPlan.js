'use strict'
$(function () {
    var customTable =  {

    }

    /**
     * 表格多条件搜索
     * @param tableId
     * @param searchFormId
     */
    var searchTable = function(tableId,searchFormId) {
        var params = $("#"+tableId).bootstrapTable('getOptions');
        params.queryParams= function (params) {
           $.each($("#"+searchFormId).serializeArray(),function (i,field) {
               if(null != field.value && ""!=field.value){
                   params[field.name] = field.value;
               }
           });
           console.info(params);
            return params;
        }
        $("#"+tableId).bootstrapTable('refresh',params);
    }

    $("#search").click(function () {
        searchTable('buyPlanTable','searchForm');
    });

    $("#reset").click(function () {
        $('#searchForm')[0].reset();
    });


    var stickyHeaderOffsetY = 0;
    if ( $('.navbar-fixed-top').css('height') ) {
        stickyHeaderOffsetY = +$('.navbar-fixed-top').css('height').replace('px','');
    }
    if ( $('.navbar-fixed-top').css('margin-bottom') ) {
        stickyHeaderOffsetY += +$('.navbar-fixed-top').css('margin-bottom').replace('px','');
    }
    $('#buyPlanTable').bootstrapTable('destroy').bootstrapTable({
        url: '/buyPlan',
        striped:true,
        sortStable:true,
        toolbar: '#searchDiv', //工具按钮用哪个容器
        stickyHeader: true,
//        pagination: true,
        showRefresh:true,
        // search:true,
        // searchAlign:'left',
        stickyHeaderOffsetY: stickyHeaderOffsetY +'px',
        columns: [{
            checkbox: true
        }, {
            field: 'commonName',
            title: '商品名称',
            titleTooltip:'商品名称',
            editable: {
                type: 'text',
                mode:'inline',
                showbuttons:false,
                onblur:'submit',
                validate: function (value) {
                    if ($.trim(value) == '') {
                        return '标题不能为空!';
                    }
                }
            }
        }, {
            field: 'goodsSpec',
            title: '规格'
            ,editable: {
                type: 'text',
                mode:'inline',
                showbuttons:false,
                onblur:'submit',
                validate: function (value) {
                    if ($.trim(value) == '') {
                        return '标题不能为空!';
                    }
                }
            }
        }, {
            field: 'goodsUtil',
            title: '单位'
            ,editable: {
                type: 'text',
                mode:'inline',
                showbuttons:false,
                onblur:'submit',
                validate: function (value) {
                    if ($.trim(value) == '') {
                        return '标题不能为空!';
                    }
                }
            }
        }, {
            field: 'goodsFactory',
            title: '厂家'
            ,editable: {
                type: 'text',
                mode:'inline',
                showbuttons:false,
                onblur:'submit',
                validate: function (value) {
                    if ($.trim(value) == '') {
                        return '标题不能为空!';
                    }
                }
            }
        }, {
            field: 'userSupperName',
            title: '供应商'
            ,editable: {
                type: 'text',
                mode:'inline',
                showbuttons:false,
                onblur:'submit',
                validate: function (value) {
                    if ($.trim(value) == '') {
                        return '标题不能为空!';
                    }
                }
            }
        }, {
            field: 'goodsPrice',
            title: '单价',
            sortable:true
            ,editable: {
                type: 'text',
                mode:'inline',
                showbuttons:false,
                onblur:'submit',
                validate: function (value) {
                    if ($.trim(value) == '') {
                        return '标题不能为空!';
                    }
                }
            }
        }, {
            field: 'sellPrice',
            title: '零售价'
            ,editable: {
                type: 'text',
                mode:'inline',
                showbuttons:false,
                onblur:'submit',
                validate: function (value) {
                    if ($.trim(value) == '') {
                        return '标题不能为空!';
                    }
                }
            }
        }, {
            field: 'planNum',
            title: '计划数量'
            ,editable: {
                type: 'text',
                mode:'inline',
                showbuttons:false,
                onblur:'submit',
                validate: function (value) {
                    if ($.trim(value) == '') {
                        return '标题不能为空!';
                    }
                }
            }
        }, {
            field: 'itemAmount',
            title: '小计'
            ,editable: {
                type: 'text',
                mode:'inline',
                showbuttons:false,
                onblur:'submit',
                validate: function (value) {
                    if ($.trim(value) == '') {
                        return '标题不能为空!';
                    }
                }
            }
        }, {
            field: 'monthUsed',
            title: '月用量'
            ,editable: {
                type: 'text',
                mode:'inline',
                showbuttons:false,
                onblur:'submit',
                validate: function (value) {
                    if ($.trim(value) == '') {
                        return '标题不能为空!';
                    }
                }
            }
        }, {
            field: 'storageNum',
            title: '库存量'
            ,editable: {
                type: 'text',
                mode:'inline',
                showbuttons:false,
                onblur:'submit',
                validate: function (value) {
                    if ($.trim(value) == '') {
                        return '标题不能为空!';
                    }
                }
            }
        }, {
            field: 'lastNo',
            title: '上批批号'
            ,editable: {
                type: 'text',
                mode:'inline',
                showbuttons:false,
                onblur:'submit',
                validate: function (value) {
                    if ($.trim(value) == '') {
                        return '标题不能为空!';
                    }
                }
            }
        }, {
            field: 'remark',
            title: '备注'
            ,editable: {
                type:'select',
                mode:'inline',
                showbuttons:false,
                onblur:'submit',
                validate: function (value) {
                    if ($.trim(value) == '') {
                        return '标题不能为空!';
                    }
                },
                value: 2,
                source: [
                    {value: 1, text: 'Active'},
                    {value: 2, text: 'Blocked'},
                    {value: 3, text: 'Deleted'}
                ]
            }
        }],
        onEditableSave: function (field, row, oldValue, $el) {
            $.ajax({
                type: "post",
                url: "/Editable/Edit",
                data: row,
                dataType: 'JSON',
                success: function (data, status) {
                    if (status == "success") {
                        alert('提交数据成功');
                    }
                },
                error: function () {
                    alert('编辑失败');
                },
                complete: function () {

                }

            });
        }
    });
});