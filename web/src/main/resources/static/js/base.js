var Base = {
    failLayerMsg: function (msg) {
        layer.msg(msg, {icon: 5});
    },
    successLayerMsg : function (msg) {
        layer.msg(msg, {icon: 6});
    },
    failSweetAlert: function (msg) {
        swal(
            '请求结果',
            msg,
            'error'
        );
    },
    successSweetAlert: function (msg) {
        swal(
            '请求结果',
            '1',
            'success'
        );
    },
    deleteSweetAlertConfirm: function (url, data, callback) {
        swal({
                title: '确定删除吗？',
                text: "你将无法恢复删除的数据！!",
                type: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                confirmButtonText: '确定'
            },
            function (isConfirm) {
                if (isConfirm) {
                    Base.deleteAjax(url, data, callback);
                }
            });
    },
    ajax: function (type, url, data, callback) {
        var index;
        $.ajax({
            url: url,
            type: type,
            contentType: "application/json",
            dataType: "json",
            data: data,
            beforeSend: function () {
                index = layer.load();
            },
            success: function (resultdata) {
                layer.close(index);
                if (resultdata.successful) {
                    callback(resultdata);
                } else {
                    Base.failLayerMsg(resultdata.message);
                }

            },
            error: function (xhr, textstatus, thrown) {
                layer.close(index);
                console.info(xhr);
                console.info(textstatus);
                console.info(thrown);
            }
        });
    }
    ,
    getAjax: function (url, data, callback) {
        Base.ajax('get', url, data, callback);
    }
    ,
    postAjax: function (url, data, callback) {
        Base.ajax('post', url, data, callback);
    }
    ,
    putAjax: function (url, data, callback) {
        Base.ajax('put', url, data, callback);
    }
    ,
    deleteAjax: function (url, data, callback) {
        Base.ajax('delete', url, data, callback);
    }
    ,
    formCommit: function (formId, commitUrl, callback) {
        var index;
        var data = $("#" + formId).serialize();
        $.ajax({
            type: "POST",
            url: commitUrl,
            data: data,
            beforeSend: function () {
                index = layer.load();
            },
            success: function (resultdata) {
                layer.close(index);
                if (resultdata.successful) {
                    callback(resultdata);
                } else {
                    Base.failLayerMsg(resultdata.message);
                }
            },
            error: function (xhr, textstatus, thrown) {

            }
        });
    }
    ,
    loadPage: function (url) {
        $("#switchBody").load(url, function (data, status, xhr) {
            if (xhr.getResponseHeader('sessionstatus') == 'timeout') {
                window.location = "/";
            }
            if (data.match("^\{(.+:.+,*){1,}\}$")) {
                $(".tpl-content-wrapper").empty();
                data = JSON.parse(data);
                if (data.status == "403") {
                    layer.confirm(data.message, {
                        icon: 3,
                        title: '提示',
                        btn: ['重新登录', '取消'] //按钮
                    }, function (index, layero) {
                        window.location = "/";
                    });
                }
            }
        });
    },
    dataTableQueryParams : function(data,searchFormId) {
        var order = data.order;
        var columns = data.columns;
        var index = order[0].column;
        data.sort = order[0].dir;
        data.order = columns[index].data;
        $.each($("#"+searchFormId).serializeArray(),function (i,field) {
            if(null != field.value && ""!=field.value){
                data[field.name] = field.value;
            }
        });
    },
    dataTableParams :function (data, callback, settings) {
        var params = {};
        var searchFormId = settings.oInit.searchFormId;
        var url = settings.oInit.ajaxUrl;
        var order = data.order;
        var columns = data.columns;
        var index = order[0].column;
        params.sort = order[0].dir;
        params.order = columns[index].data;
        params.start = data.start;
        params.length = data.length;
        params.draw = data.draw;

        $.each($("#"+searchFormId).serializeArray(),function (i,field) {
            if(null != field.value && ""!=field.value){
                params[field.name] = field.value;
            }
        });
        $.ajax({
            type: "GET",
            url: url,
            cache : false,  //禁用缓存
            data: params,    //传入已封装的参数
            dataType: "json",
            success: function(result) {
                //异常判断与处理
                if (result.errorCode) {
                    // $.dialog.alert("查询失败。错误码："+result.errorCode);
                    return;
                }

                //封装返回数据，这里仅演示了修改属性名
                var returnData = {};
                returnData.draw = data.draw;//这里直接自行返回了draw计数器,应该由后台返回
                returnData.recordsTotal = result.recordsTotal;
                returnData.recordsFiltered = result.recordsFiltered;//后台不实现过滤功能，每次查询均视作全部结果
                returnData.data = result.data;
                //调用DataTables提供的callback方法，代表数据已封装完成并传回DataTables进行渲染
                //此时的数据需确保正确无误，异常判断应在执行此回调前自行处理完毕
                callback(returnData);
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                // $.dialog.alert("查询失败");
                // $wrapper.spinModal(false);
            }
        });
    }
}