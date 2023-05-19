export { }

// enum Xxx {
//     a = 10,
//     b = '200'
// }

let code: string | number = 123

enum StatusCode {
    success = 200,
    paramsError = 400,
    serverError = 500
}

if (code === StatusCode.success) {
    console.log('成功');
} else if (code === StatusCode.paramsError) {
    console.log('失败');
} else if (code === StatusCode.serverError) {
    console.log('服务器异常');
} else {
    console.log('未知错误');
}

enum StatusCode2 {
    success,
    paramsError = 400,
    serverError
}
console.log(StatusCode2);
