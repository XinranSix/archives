export { }

let a: any = 1
a.toFixed(2)

let b: unknown = 1
// b.toFixed(2)

if (typeof b === 'number') {
    b.toFixed(2)
}