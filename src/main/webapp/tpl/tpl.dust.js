/*tpl1*/(function(){dust.register("tpl1.dust",body_0);function body_0(chk,ctx){return chk.write("<div class=\"panel-heading\">").reference(ctx.get(["title"], false),ctx,"h").write("</div><div class=\"panel-body\"><p>").reference(ctx.get(["content"], false),ctx,"h").write("</p></div>");}return body_0;})();
/*tpl2*/(function(){dust.register("tpl2.dust",body_0);function body_0(chk,ctx){return chk.write("<div class=\"panel-body\"><div class=\"col-sm-6 col-md-12\"><img width=\"100%\" height=\"100%\" src=\"").reference(ctx.get(["image"], false),ctx,"h").write("\" /></div></div><div class=\"panel-footer\">").reference(ctx.get(["description"], false),ctx,"h").write("</div>");}return body_0;})();
/*tpl3*/(function(){dust.register("tpl3.dust",body_0);function body_0(chk,ctx){return chk.write("<div class=\"panel-body\"><div class=\"jumbotron\"><img width=\"100%\" height=\"100%\" src=\"").reference(ctx.get(["image"], false),ctx,"h").write("\" />").reference(ctx.get(["description"], false),ctx,"h").write("</div>").reference(ctx.get(["comment"], false),ctx,"h").write("</div>");}return body_0;})();