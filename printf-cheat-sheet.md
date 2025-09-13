# Java `printf` Cheat Sheet

This guide summarizes how to use `System.out.printf()` in Java to format output.  
`printf` allows you to control how numbers, strings, and other values are displayed.

---

## Basic Syntax
```java
System.out.printf("format string", values);
```

- **`format string`**: A string containing text and format specifiers.
- **`values`**: Variables or values that will be inserted into the format specifiers.

---

## Common Format Specifiers

| Specifier | Type        | Example                | Output              |
|-----------|-------------|------------------------|---------------------|
| `%d`      | Integer     | `System.out.printf("%d", 42);` | `42`              |
| `%f`      | Floating-point | `System.out.printf("%f", 3.14);` | `3.140000` |
| `%.2f`    | Floating-point (2 decimals) | `System.out.printf("%.2f", 3.14159);` | `3.14` |
| `%s`      | String      | `System.out.printf("%s", "Hello");` | `Hello` |
| `%c`      | Character   | `System.out.printf("%c", 'A');` | `A` |
| `%n`      | New line    | `System.out.printf("Line1%nLine2");` | Line1 <br> Line2 |

---

## Width and Alignment

You can specify **minimum width** and alignment.

| Format        | Example                                | Output        |
|---------------|----------------------------------------|---------------|
| `%5d`         | `System.out.printf("%5d", 42);`        | &nbsp;&nbsp;&nbsp;&nbsp;42 |
| `%-5d`        | `System.out.printf("%-5d", 42);`       | 42&nbsp;&nbsp;&nbsp;&nbsp; |
| `%10s`        | `System.out.printf("%10s", "Hi");`     | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Hi |
| `%-10s`       | `System.out.printf("%-10s", "Hi");`    | Hi&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; |

---

## Controlling Decimal Places

```java
System.out.printf("%.1f%n", 3.14159); // 3.1
System.out.printf("%.3f%n", 3.14159); // 3.142
```

---

## Combining Multiple Values

```java
int age = 20;
String name = "Alex";
double gpa = 3.75;

System.out.printf("Name: %s, Age: %d, GPA: %.2f%n", name, age, gpa);
// Output: Name: Alex, Age: 20, GPA: 3.75
```

---

## Flags

| Flag | Description | Example | Output |
|------|-------------|---------|--------|
| `0`  | Pad with zeros | `System.out.printf("%05d", 42);` | `00042` |
| `+`  | Show sign | `System.out.printf("%+d", 42);` | `+42` |
| `,`  | Use grouping separators | `System.out.printf("%,d", 1000000);` | `1,000,000` |

---

## Quick Reference

- **Integer**: `%d`
- **Floating point**: `%f`
- **String**: `%s`
- **Character**: `%c`
- **New line**: `%n`
- **Decimals**: `%.nf`
- **Width**: `%nd` or `%ns`
- **Left-align**: `%-nd`

---

## Practice Examples

```java
System.out.printf("Pi approx: %.2f%n", 3.14159);   // Pi approx: 3.14
System.out.printf("Value: %08d%n", 123);           // Value: 00000123
System.out.printf("|%-10s|%10s|%n", "left", "right");
// |left      |     right|
```

---

✅ Use `printf` when you need clean, formatted output!  
