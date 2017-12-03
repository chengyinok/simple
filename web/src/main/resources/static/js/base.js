var Base = {
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
                callback(resultdata);
            },
            error: function (xhr, textstatus, thrown) {

            }
        });
    },
    getAjax: function (url, data, callback) {
        this.ajax('get', url, data, callback);
    },
    postAjax: function (url, data, callback) {
        this.ajax('post', url, data, callback);
    },
    putAjax: function (url, data, callback) {
        this.ajax('put', url, data, callback);
    },
    deleteAjax: function (url, data, callback) {
        this.ajax('delete', url, data, callback);
    },
    formCommit: function (formId, commitUrl,callback) {
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
                callback(resultdata);
            },
            error: function (xhr, textstatus, thrown) {

            }
        });
    },
    loadPage: function (url) {
        $("#contentDiv").load(url, function (data, status, xhr) {
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