export { }

interface DatItf {
    a: number
    b: number
}

interface ResItf {
    code: number
    data: DatItf[]
    message: string
}

let p: Promise<ResItf> = new Promise((resolve, reject) => {
    resolve({
        code: 0,
        data: [{ a: 1, b: 2 }, { a: 11, b: 22 }],
        message: ''
    })
})

p.then(res => {
    if (res.code === 0) {
        // do something
        res.data.map(item => item.a)
    }
}).catch(err => {

})