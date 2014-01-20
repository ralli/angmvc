package angmvc.web.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NoCacheFilter implements Filter {
  private static final Logger log = LoggerFactory.getLogger(NoCacheFilter.class);

  /**
   * Empty implementation of the Filter-Interface
   *
   * @param filterConfig the Filterconfig
   * @throws javax.servlet.ServletException
   */
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
                       FilterChain chain) throws IOException, ServletException {
    HttpServletResponse res = (HttpServletResponse) response;
    res.addHeader("Pragma", "no-cache");
    res.addHeader("Cache-Control", "no-cache, no-store");
    chain.doFilter(request, response);
  }

  /**
   * Empty implementation of the Filter-Interface
   */
  @Override
  public void destroy() {
  }
}
