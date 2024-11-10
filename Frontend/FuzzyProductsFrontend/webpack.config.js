const path = require('path');module.exports = {
  entry: './src/main.ts',
  devtool: 'inline-source-map',
  devServer: {
      static: {
      directory: path.join(__dirname, "dist")
    },

    compress: true,
    port: 3010, // default 8000
  },
  module: {
    rules: [
      {
        test: /\.tsx?$/,
        use: 'ts-loader',
        exclude: /node_modules/
      }
    ]
  },
  resolve: {
    extensions: [ '.tsx', '.ts', '.js' ]
  },
  output: {
    filename: 'bundle.js',
    path: path.resolve(__dirname, 'dist')
  }
};