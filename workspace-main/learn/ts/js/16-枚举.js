"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
// enum Xxx {
//     a = 10,
//     b = '200'
// }
let code = 123;
var StatusCode;
(function (StatusCode) {
    StatusCode[StatusCode["success"] = 200] = "success";
    StatusCode[StatusCode["paramsError"] = 400] = "paramsError";
    StatusCode[StatusCode["serverError"] = 500] = "serverError";
})(StatusCode || (StatusCode = {}));
if (code === StatusCode.success) {
    console.log('成功');
}
else if (code === StatusCode.paramsError) {
    console.log('失败');
}
else if (code === StatusCode.serverError) {
    console.log('服务器异常');
}
else {
    console.log('未知错误');
}
var StatusCode2;
(function (StatusCode2) {
    StatusCode2[StatusCode2["success"] = 0] = "success";
    StatusCode2[StatusCode2["paramsError"] = 400] = "paramsError";
    StatusCode2[StatusCode2["serverError"] = 401] = "serverError";
})(StatusCode2 || (StatusCode2 = {}));
console.log(StatusCode2);
