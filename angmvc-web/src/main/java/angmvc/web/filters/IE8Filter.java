package angmvc.web.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IE8Filter implements Filter {
  private static final Logger log = LoggerFactory.getLogger(IE8Filter.class);

  /**
   * Empty implementation of the Filter-Interface
   *
   * @param filterConfig the Filterconfig
   * @throws ServletException
   */
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
                       FilterChain chain) throws IOException, ServletException {
    HttpServletResponse res = (HttpServletResponse) response;
    res.addHeader("X-UA-Compatible", "IE=edge");
    chain.doFilter(request, response);
  }

  /**
   * Empty implementation of the Filter-Interface
   */
  @Override
  public void destroy() {
  }
}
