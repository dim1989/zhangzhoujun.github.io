
import 'package:flutter/material.dart';
import '../web/common_webview.dart';

class RouteUtil{

  static route2Web(BuildContext context, String title, String url) {
    if(null == url){
      return;
    }
    Navigator.of(context).push(new PageRouteBuilder(
        opaque: false,
        pageBuilder: (BuildContext context, _, __) {
          return new CommonWebView(title, url);
        },
        transitionsBuilder: (_, Animation<double> animation, __, Widget child) {
          return new FadeTransition(
            opacity: animation,
            child: new FadeTransition(
              opacity:
              new Tween<double>(begin: 0.5, end: 1.0).animate(animation),
              child: child,
            ),
          );
        }));
  }

}
