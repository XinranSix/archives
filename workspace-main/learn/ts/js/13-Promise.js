"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
let p = new Promise((resolve, reject) => {
    resolve({
        code: 0,
        data: [{ a: 1, b: 2 }, { a: 11, b: 22 }],
        message: ''
    });
});
p.then(res => {
    if (res.code === 0) {
        // do something
        res.data.map(item => item.a);
    }
}).catch(err => {
});
