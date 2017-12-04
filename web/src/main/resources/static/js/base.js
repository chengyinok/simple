var Base = {
    failLayerMsg: function (msg) {
        layer.msg(msg, {icon: 5});
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
    }


}