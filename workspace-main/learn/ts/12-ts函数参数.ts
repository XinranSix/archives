export { }

function fn(a: number, b: number = 3): number {
    return a + b
}

// console.log(fn(1, 2));

// console.log(fn(4));

function fn1(a: number, b?: number): number {
    console.log(b);
    return 1
}

// fn1(1, 2)
// fn1(1)

function fn2(...arr: number[]) {
    // console.log(a);
    // console.log(b);
    console.log(arr);
}

// fn2(1, 2, 3, 4, 5)

let arr1 = [1, 2, 3]
let arr2 = [...arr1]

arr1[0] = 4
// console.log(arr1);
// console.log(arr2);

let obj1 = { a: 1, b: 2, c: [1, 2, 3] }
let obj2 = { ...obj1 }

obj1.c[0] = 1000
console.log(obj1);
console.log(obj2);
