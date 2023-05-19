export { }

function fn(n: number): number {
    return n
}

fn(100)

function fn1<T>(n: T): T {
    return n
}

fn1<number>(1)
fn1<boolean>(true)
fn1<string>('123')
fn1<'hello'>('hello')