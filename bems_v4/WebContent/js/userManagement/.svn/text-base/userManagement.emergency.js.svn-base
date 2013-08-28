/*
 * @author:秦凡鹏
 * @date：7.13
 * @description:数据采集功能的右边页面对应的js文件
 */
$(document).ready(function(){
    // sun 2012-7-19
    $("#user_manage_emergency_add_div").show();
    loademergncy();
    // 加载表单 （加载应急小组列表）
    function loademergncy(){
        var datas = new Array();
        
        $.ajax({
            type: "GET",
            url: $.getRootPath() +
            "/rest/emergncyGroupService/getemergncygroup",
            success: function(msg){
                var $xml = $(msg);
                var groups = $xml.find("emergncyGroup");
                groups.each(function(i){
                    var $this = $(this);
                    var emergncyGroupId = $this.find("emergncyGroupId").text();
                    var groupName = $this.find("groupName").text();
                    var description = $this.find("description").text();
                    var a = {
                        "id": i,
                        "name": groupName
                    };
                    datas[i] = a;
                    $("<tr><td>" +
                    (i + 1) +
                    "<input type=\"hidden\" value=\"" +
                    emergncyGroupId +
                    "\"/></td><td>" +
                    groupName +
                    "</td><td><a  href=\"#\" class=\"emergncymember\">管理小组成员</a></td><td><a href=\"#\">查看/修改</a></td><td><a href=\"#\" class=\"emergncydel\">删除</a></td></tr>").appendTo("#emergency_manage_look_table");
                    
                    var data = {
                        name: '仪表明细',
                        list_id: '***',
                        table: datas
                    };
                    
                    // 设置debug模式
                    $.jTemplatesDebugMode(true);
                    // 附上模板
                    $("#emergncy_table").setTemplateURL("template/emergncy.table.template");
                    // 给模板加载数据
                    $("#emergncy_table").processTemplate(data);
                });
                
            }
        });
        
        
        
    }
    
    // 删除小组功能
    $(".emergncydel").live('click', function(){
        var true_or_false = window.confirm("您确定要删除该用户吗？");
        var tr = $(this).parent().parent();
        var emergncyGroupId = tr.children("td:first").children("input:first").attr("value");
        if (true_or_false) {
            $.ajax({
                type: "GET",
                url: $.getRootPath() +
                "/rest/emergncyGroupService/del/" +
                emergncyGroupId,
                success: function(data){
                    var $xml = $(data);
                    // 取出返回的结果
                    var update_user_meg = $xml.find("message").text();
                    $("#emergency_manage_look_table").find("tr").each(function(i){
                        if (i > 0) 
                            $(this).remove();
                    });
                    loademergncy();
                    
                }
            });
        }
        
    });
    
    // 查看应急小组成员功能
    
    $(".emergncymember").live('click', function(){
    
        $("#user_manage_emergency_add_div").hide();
        $("#user_add").hide();
        $("#emergency_member_manage_look_div").slideDown(500);
        
        var tr = $(this).parent().parent();
        var emergncyGroupId = tr.children("td:first").children("input:first").attr("value");
    });
    
    $("#emergency_add_type").click(function(){
        $("#user_add").slideDown(500);
    });
    $("#emergency_member_manage_type").click(function(){
        $("#user_manage_emergency_add_div").hide();
        $("#emergency_member_manage_div").slideDown(500);
    });
    $("#user_manage_emergency_add_member_btn").click(function(){
        $("#emergency_member_manage_look_div").hide();
        $("#emergency_member_manage_add_div").slideDown(500);
    });
    $("#user_manage_emergency_look_member_btn").click(function(){
        $("#emergency_member_manage_add_div").hide();
        $("#emergency_member_manage_look_div").slideDown(500);
    });
    
    $("#water_basic_data_submitBtn").click(function(){
        $.ajax({
            type: "POST",
            url: $.getRootPath() +
            "/rest/emergncyGroupService/createemergncygroup",
            data: $('#user_manage_emergency_add_form').serialize(),
            success: function(msg){
                $xml = $(msg);
                //alert($xml.find("message").text());
                $("#user_add").hide();
                $("#emergency_manage_look_table").find("tr").each(function(i){
                    if (i > 0) 
                        $(this).remove();
                });
                loademergncy();
            }
        });
    });
    
    //加载小组成员
    function loademergncystaff(){
    
        $.ajax({
            type: "POST",
            url: $.getRootPath() +
            "/rest/emergncyGroupService/",
            data: $('#user_manage_emergency_add_form').serialize(),
            success: function(msg){
                $xml = $(msg);
                //alert($xml.find("message").text());
            }
        });
        
    }
    
    $("#black_btn").click(function(){
    
        $("#user_add").hide();
        
    });
    
});
