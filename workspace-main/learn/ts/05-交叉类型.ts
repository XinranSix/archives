export { }

// &

// let a: number & string;

// a = '1'

let obj: { name: string, age: number } & { height: number, age: 18};

obj = {
    name: '张三',
    age: 18,
    height: 180
}