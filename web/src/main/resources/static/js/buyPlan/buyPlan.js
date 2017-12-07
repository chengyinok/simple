'use strict'
$(function () {
    /**
     * 表格多条件搜索
     * @param tableId
     * @param searchFormId
     */
    var searchTable = function(tableId,searchFormId) {
        var params = $("#"+tableId).bootstrapTable('getOptions');
        params.queryParams= function (params) {
            params.page = 1;
           $.each($("#"+searchFormId).serializeArray(),function (i,field) {
               if(null != field.value && ""!=field.value){
                   params[field.name] = field.value;
               }
           });
            return params;
        }
        $("#"+tableId).bootstrapTable('refresh',params);
    }

    $("#search").click(function () {
        searchTable('buyPlanTable','searchForm');
    });

    $(".js-inputClear").click(function () {
        $(this).prev().val('');
    });

    // $("#reset").click(function () {
    //     $('#searchForm')[0].reset();
    // });


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
        resizable:true,
        // showFooter: true,
        // groupBy:"true",
        // groupByField:"commonName",
        locale:'zh-CN',        //中文
        pagination: true,
        // paginationHAlign:'left',
        // paginationDetailHAlign:'right',
        // paginationPreText:'上一页',
        // paginationNextText:'下一页',
        // fixedColumns: true,
        // fixedNumber: 1,
        showRefresh:true,
        // search:true,
        // searchAlign:'left',
        sidePagination:'server',
        stickyHeader: true,
        stickyHeaderOffsetY: stickyHeaderOffsetY +'px',
        queryParams  : function (params) {
            params.page = this.pageNumber;
            return params;
        },
        columns: [{
            checkbox: true
        }, {
            field: 'commonName',
            title: '商品名称',
            titleTooltip:'商品名称',
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
            field: 'goodsSpec',
            title: '规格'
            ,sortable:true
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
            ,sortable:true
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
            ,sortable:true
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
            ,sortable:true
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
            ,sortable:true
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
            ,sortable:true
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
            ,sortable:true
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
            ,sortable:true
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
            ,sortable:true
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
            ,sortable:true
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
            ,sortable:true
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
        },{
            title:'操作'
            ,align:'center'
            ,formatter:function () {
                var html = '<div class="btn-group">';
                // html += '<button type="button" class="btn btn-info"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span>编辑</button>';
                html += '<button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>删除</button>';
                // html += '<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>详情</button>';
                return html;
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