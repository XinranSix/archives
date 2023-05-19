export { }

// function fn(a: number, b: number): number {
//     return a + b
// }

interface FunItf {
    (p: string): number
}

// let fn: FunItf = (p: string): number => {
//     return 1
// }

// fn('')

// type FunType = (p: string) => void

// let fn2: FunType = (p: string): void => { 

// }

// fn2('')


interface ObjItf {
    fn: FunItf
}

// let obj: ObjItf = {
//     fn: (str) => {
//         return 1
//     }
// }

// obj.fn('')

type ObjType = {
    fn: FunItf
}

let obj: ObjType = {
    fn: (p: string): number => {
        return 1
    }
}

obj.fn('')