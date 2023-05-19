export { }

let numAndStr: number | string = 10
numAndStr = '10'

// numAndStr = true

let numAndStr2: 1 | '2' = 1

// numAndStr2 = 2
numAndStr2 = '2'

let obj: { a: 1 } | { b: '3' }

obj = { a: 1 }

obj = { b: '3' }
obj = { a: 1, b: '3' }
