module library.impl {
  requires library.api;
  provides com.github.piotrczyszczon.simpleworkspace.modularity.library.Office with com.github.piotrczyszczon.simpleworkspace.modularity.library.impl.OfficeImpl;
}